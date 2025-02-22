// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.web;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import nl.bzk.brp.model.data.autaut.Authenticatiemiddel;
import nl.bzk.brp.model.data.autaut.Certificaat;
import nl.bzk.brp.model.data.autaut.Functie;
import nl.bzk.brp.model.data.autaut.HisAuthenticatiemiddel;
import nl.bzk.brp.model.data.kern.Partij;
import nl.bzk.brp.model.data.kern.Rol;
import nl.bzk.brp.model.data.lev.Lev;
import nl.bzk.brp.model.web.AuthenticatiemiddelController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect AuthenticatiemiddelController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String AuthenticatiemiddelController.create(@Valid Authenticatiemiddel authenticatiemiddel, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, authenticatiemiddel);
            return "authenticatiemiddels/create";
        }
        uiModel.asMap().clear();
        authenticatiemiddel.persist();
        return "redirect:/authenticatiemiddels/" + encodeUrlPathSegment(authenticatiemiddel.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String AuthenticatiemiddelController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Authenticatiemiddel());
        return "authenticatiemiddels/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String AuthenticatiemiddelController.show(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("authenticatiemiddel", Authenticatiemiddel.findAuthenticatiemiddel(id));
        uiModel.addAttribute("itemId", id);
        return "authenticatiemiddels/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String AuthenticatiemiddelController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("authenticatiemiddels", Authenticatiemiddel.findAuthenticatiemiddelEntries(firstResult, sizeNo));
            float nrOfPages = (float) Authenticatiemiddel.countAuthenticatiemiddels() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("authenticatiemiddels", Authenticatiemiddel.findAllAuthenticatiemiddels());
        }
        return "authenticatiemiddels/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String AuthenticatiemiddelController.update(@Valid Authenticatiemiddel authenticatiemiddel, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, authenticatiemiddel);
            return "authenticatiemiddels/update";
        }
        uiModel.asMap().clear();
        authenticatiemiddel.merge();
        return "redirect:/authenticatiemiddels/" + encodeUrlPathSegment(authenticatiemiddel.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String AuthenticatiemiddelController.updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, Authenticatiemiddel.findAuthenticatiemiddel(id));
        return "authenticatiemiddels/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String AuthenticatiemiddelController.delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Authenticatiemiddel authenticatiemiddel = Authenticatiemiddel.findAuthenticatiemiddel(id);
        authenticatiemiddel.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/authenticatiemiddels";
    }
    
    void AuthenticatiemiddelController.populateEditForm(Model uiModel, Authenticatiemiddel authenticatiemiddel) {
        uiModel.addAttribute("authenticatiemiddel", authenticatiemiddel);
        uiModel.addAttribute("certificaats", Certificaat.findAllCertificaats());
        uiModel.addAttribute("functies", Functie.findAllFuncties());
        uiModel.addAttribute("hisauthenticatiemiddels", HisAuthenticatiemiddel.findAllHisAuthenticatiemiddels());
        uiModel.addAttribute("partijs", Partij.findAllPartijs());
        uiModel.addAttribute("rols", Rol.findAllRols());
        uiModel.addAttribute("levs", Lev.findAllLevs());
    }
    
    String AuthenticatiemiddelController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
