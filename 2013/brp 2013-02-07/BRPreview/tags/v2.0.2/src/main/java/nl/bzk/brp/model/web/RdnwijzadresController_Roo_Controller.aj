// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.web;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import nl.bzk.brp.model.data.kern.HisPersadres;
import nl.bzk.brp.model.data.kern.Persadres;
import nl.bzk.brp.model.data.kern.Rdnwijzadres;
import nl.bzk.brp.model.web.RdnwijzadresController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect RdnwijzadresController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String RdnwijzadresController.create(@Valid Rdnwijzadres rdnwijzadres, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, rdnwijzadres);
            return "rdnwijzadreses/create";
        }
        uiModel.asMap().clear();
        rdnwijzadres.persist();
        return "redirect:/rdnwijzadreses/" + encodeUrlPathSegment(rdnwijzadres.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String RdnwijzadresController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Rdnwijzadres());
        return "rdnwijzadreses/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String RdnwijzadresController.show(@PathVariable("id") Short id, Model uiModel) {
        uiModel.addAttribute("rdnwijzadres", Rdnwijzadres.findRdnwijzadres(id));
        uiModel.addAttribute("itemId", id);
        return "rdnwijzadreses/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String RdnwijzadresController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("rdnwijzadreses", Rdnwijzadres.findRdnwijzadresEntries(firstResult, sizeNo));
            float nrOfPages = (float) Rdnwijzadres.countRdnwijzadreses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("rdnwijzadreses", Rdnwijzadres.findAllRdnwijzadreses());
        }
        return "rdnwijzadreses/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String RdnwijzadresController.update(@Valid Rdnwijzadres rdnwijzadres, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, rdnwijzadres);
            return "rdnwijzadreses/update";
        }
        uiModel.asMap().clear();
        rdnwijzadres.merge();
        return "redirect:/rdnwijzadreses/" + encodeUrlPathSegment(rdnwijzadres.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String RdnwijzadresController.updateForm(@PathVariable("id") Short id, Model uiModel) {
        populateEditForm(uiModel, Rdnwijzadres.findRdnwijzadres(id));
        return "rdnwijzadreses/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String RdnwijzadresController.delete(@PathVariable("id") Short id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Rdnwijzadres rdnwijzadres = Rdnwijzadres.findRdnwijzadres(id);
        rdnwijzadres.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/rdnwijzadreses";
    }
    
    void RdnwijzadresController.populateEditForm(Model uiModel, Rdnwijzadres rdnwijzadres) {
        uiModel.addAttribute("rdnwijzadres", rdnwijzadres);
        uiModel.addAttribute("hispersadreses", HisPersadres.findAllHisPersadreses());
        uiModel.addAttribute("persadreses", Persadres.findAllPersadreses());
    }
    
    String RdnwijzadresController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
