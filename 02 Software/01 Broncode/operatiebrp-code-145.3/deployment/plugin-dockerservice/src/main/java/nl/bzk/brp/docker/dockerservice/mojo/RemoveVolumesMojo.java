package nl.bzk.brp.docker.dockerservice.mojo;

import java.util.ArrayList;
import java.util.List;
import nl.bzk.brp.docker.dockerservice.mojo.docker.DockerExecutor;
import nl.bzk.brp.docker.dockerservice.mojo.docker.DockerExecutor.DockerExecutionException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Mojo to remove all volumes from a docker node.
 */
@Mojo(name = "remove-volumes", requiresProject = false)
public final class RemoveVolumesMojo extends AbstractMojo {

    /**
     * Extra docker argumenten. Kan bijvoorbeeld een alternatieve host (-H &lt;host>:&ltport>) of
     * TLS parameters bevatten.
     */
    @Parameter(property = "dockerArguments", defaultValue = "")
    private String dockerArguments;

    /** Filter. */
    @Parameter(property = "filter", defaultValue = "")
    private String filter;

    /** Ignore failures. */
    @Parameter(property = "ignoreFailures", defaultValue = "false")
    private boolean ignoreFailures;

    /**
     * Set docker arguments.
     *
     * @param dockerArguments docker arguments.
     */
    public void setDockerArguments(final String dockerArguments) {
        this.dockerArguments = dockerArguments;
    }

    /**
     * Set filter.
     *
     * @param filter filter
     */
    public void setFilter(final String filter) {
        this.filter = filter;
    }

    /**
     * Set ignore failures.
     *
     * @param ignoreFailures ignore failures.
     */
    public void setIgnoreFailures(final boolean ignoreFailures) {
        this.ignoreFailures = ignoreFailures;
    }

    @Override
    public void execute() throws MojoExecutionException {
        final DockerExecutor executor = new DockerExecutor(getLog()::info, getLog()::warn, dockerArguments);
        final List<String> volumes;
        try {
            volumes = listVolumes(executor);
        } catch (final DockerExecutionException e) {
            getLog().warn("Kon lijst met volumes niet opvragen: " + e.getMessage());
            if (ignoreFailures) {
                return;
            } else {
                throw new MojoExecutionException("Kon lijst met volumes niet opvragen", e);
            }
        }

        for (final String volume : volumes) {
            if ("".equals(volume.trim())) {
                continue;
            }
            try {
                removeVolume(executor, volume);
            } catch (final DockerExecutionException e) {
                getLog().warn("Kon volume '" + volume + "' niet verwijderen: " + e.getMessage());
                if (!ignoreFailures) {
                    throw new MojoExecutionException("Kon volume niet verwijderen", e);
                }
            }
        }
    }

    private void removeVolume(final DockerExecutor executor, final String volume) throws DockerExecutionException {
        final List<String> argumenten = new ArrayList<>();
        argumenten.add("volume");
        argumenten.add("rm");
        argumenten.add(volume);

        executor.execute(argumenten);
    }

    private List<String> listVolumes(final DockerExecutor executor) throws DockerExecutionException {
        final List<String> argumenten = new ArrayList<>();
        argumenten.add("volume");
        argumenten.add("ls");
        argumenten.add("-q");
        if ((filter != null) && !"".equals(filter)) {
            argumenten.add("--filter");
            argumenten.add(filter);
        }

        return executor.execute(argumenten, true);
    }

}
