// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.web;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import nl.bzk.brp.model.data.autaut.Autorisatiebesluit;
import nl.bzk.brp.model.data.autaut.Doelbinding;
import nl.bzk.brp.model.data.autaut.Doelbindinggegevenselement;
import nl.bzk.brp.model.data.autaut.HisDoelbinding;
import nl.bzk.brp.model.data.autaut.Protocolleringsniveau;
import nl.bzk.brp.model.data.kern.Partij;
import nl.bzk.brp.model.data.lev.Abonnement;
import nl.bzk.brp.model.web.DoelbindingController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect DoelbindingController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String DoelbindingController.create(@Valid Doelbinding doelbinding, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, doelbinding);
            return "doelbindings/create";
        }
        uiModel.asMap().clear();
        doelbinding.persist();
        return "redirect:/doelbindings/" + encodeUrlPathSegment(doelbinding.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String DoelbindingController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Doelbinding());
        return "doelbindings/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String DoelbindingController.show(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("doelbinding", Doelbinding.findDoelbinding(id));
        uiModel.addAttribute("itemId", id);
        return "doelbindings/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String DoelbindingController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("doelbindings", Doelbinding.findDoelbindingEntries(firstResult, sizeNo));
            float nrOfPages = (float) Doelbinding.countDoelbindings() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("doelbindings", Doelbinding.findAllDoelbindings());
        }
        return "doelbindings/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String DoelbindingController.update(@Valid Doelbinding doelbinding, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, doelbinding);
            return "doelbindings/update";
        }
        uiModel.asMap().clear();
        doelbinding.merge();
        return "redirect:/doelbindings/" + encodeUrlPathSegment(doelbinding.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String DoelbindingController.updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, Doelbinding.findDoelbinding(id));
        return "doelbindings/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String DoelbindingController.delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Doelbinding doelbinding = Doelbinding.findDoelbinding(id);
        doelbinding.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/doelbindings";
    }
    
    void DoelbindingController.populateEditForm(Model uiModel, Doelbinding doelbinding) {
        uiModel.addAttribute("doelbinding", doelbinding);
        uiModel.addAttribute("autorisatiebesluits", Autorisatiebesluit.findAllAutorisatiebesluits());
        uiModel.addAttribute("doelbindinggegevenselements", Doelbindinggegevenselement.findAllDoelbindinggegevenselements());
        uiModel.addAttribute("hisdoelbindings", HisDoelbinding.findAllHisDoelbindings());
        uiModel.addAttribute("protocolleringsniveaus", Protocolleringsniveau.findAllProtocolleringsniveaus());
        uiModel.addAttribute("partijs", Partij.findAllPartijs());
        uiModel.addAttribute("abonnements", Abonnement.findAllAbonnements());
    }
    
    String DoelbindingController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
