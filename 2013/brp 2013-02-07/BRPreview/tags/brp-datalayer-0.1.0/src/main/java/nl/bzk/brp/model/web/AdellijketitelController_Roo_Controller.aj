// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.web;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import nl.bzk.brp.model.data.kern.Adellijketitel;
import nl.bzk.brp.model.data.kern.HisPersgeslnaamcomp;
import nl.bzk.brp.model.data.kern.HisPerssamengesteldenaam;
import nl.bzk.brp.model.data.kern.Persgeslnaamcomp;
import nl.bzk.brp.model.service.PersonService;
import nl.bzk.brp.model.web.AdellijketitelController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect AdellijketitelController_Roo_Controller {
    
    @Autowired
    PersonService AdellijketitelController.personService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String AdellijketitelController.create(@Valid Adellijketitel adellijketitel, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, adellijketitel);
            return "adellijketitels/create";
        }
        uiModel.asMap().clear();
        adellijketitel.persist();
        return "redirect:/adellijketitels/" + encodeUrlPathSegment(adellijketitel.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String AdellijketitelController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Adellijketitel());
        return "adellijketitels/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String AdellijketitelController.show(@PathVariable("id") Short id, Model uiModel) {
        uiModel.addAttribute("adellijketitel", Adellijketitel.findAdellijketitel(id));
        uiModel.addAttribute("itemId", id);
        return "adellijketitels/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String AdellijketitelController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("adellijketitels", Adellijketitel.findAdellijketitelEntries(firstResult, sizeNo));
            float nrOfPages = (float) Adellijketitel.countAdellijketitels() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("adellijketitels", Adellijketitel.findAllAdellijketitels());
        }
        return "adellijketitels/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String AdellijketitelController.update(@Valid Adellijketitel adellijketitel, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, adellijketitel);
            return "adellijketitels/update";
        }
        uiModel.asMap().clear();
        adellijketitel.merge();
        return "redirect:/adellijketitels/" + encodeUrlPathSegment(adellijketitel.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String AdellijketitelController.updateForm(@PathVariable("id") Short id, Model uiModel) {
        populateEditForm(uiModel, Adellijketitel.findAdellijketitel(id));
        return "adellijketitels/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String AdellijketitelController.delete(@PathVariable("id") Short id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Adellijketitel adellijketitel = Adellijketitel.findAdellijketitel(id);
        adellijketitel.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/adellijketitels";
    }
    
    void AdellijketitelController.populateEditForm(Model uiModel, Adellijketitel adellijketitel) {
        uiModel.addAttribute("adellijketitel", adellijketitel);
        uiModel.addAttribute("hispersgeslnaamcomps", HisPersgeslnaamcomp.findAllHisPersgeslnaamcomps());
        uiModel.addAttribute("hisperssamengesteldenaams", HisPerssamengesteldenaam.findAllHisPerssamengesteldenaams());
        uiModel.addAttribute("perses", personService.findAllPerses());
        uiModel.addAttribute("persgeslnaamcomps", Persgeslnaamcomp.findAllPersgeslnaamcomps());
    }
    
    String AdellijketitelController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
