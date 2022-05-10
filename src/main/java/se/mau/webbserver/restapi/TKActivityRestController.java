package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.tk.activity.TKActivity;
import se.mau.webbserver.entity.tk.activity.TKActivityService;
import java.util.List;

@RestController
@RequestMapping("/api/tk_activity")
public class TKActivityRestController {

    private final TKActivityService tkActivityService;

    @Autowired
    public TKActivityRestController(TKActivityService tkActivityService) {
        this.tkActivityService = tkActivityService;
    }

    @GetMapping
    public List<TKActivity> getTKActivities() {
        return tkActivityService.getTKActivities();
    }

    @GetMapping("/{id}")
    public TKActivity getTKActivities(@PathVariable Integer id) {
        return tkActivityService.getTKActivities(id);
    }

    @PostMapping
    public void addTKActivity(@RequestBody TKActivity tkActivity) {
        tkActivityService.addTKActivity(tkActivity);
    }

    @DeleteMapping("/{id}")
    public void deleteTKactivity(@PathVariable Integer id) {
        tkActivityService.deleteTKActivity(id);
    }

    @PatchMapping("/{id}")
    public void patchService(@PathVariable Integer id, @RequestBody TKActivity tkActivity) {
        tkActivityService.patchTKActivity(id, tkActivity);
    }
}
