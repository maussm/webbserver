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

/**
 * REST API klass för tabellen tk_activity.
 */
@RestController
@RequestMapping("/api/tk_activity")
public class TKActivityRestController {

    private final TKActivityService tkActivityService;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param tkActivityService Koppling mot tabellen tk_activity.
     */
    @Autowired
    public TKActivityRestController(TKActivityService tkActivityService) {
        this.tkActivityService = tkActivityService;
    }

    /**
     * URI: /api/tk_activity
     * METOD: GET
     * Hämtar alla TKActivity.
     * @return Alla TKActivity som finns.
     */
    @GetMapping
    public List<TKActivity> getTKActivities() {
        return tkActivityService.getTKActivities();
    }

    /**
     * URI: /api/tk_activity/{id}
     * METOD: GET
     * Hämtar en TKActivity med angivet id.
     * @param id Id på TKActivity.
     * @return En TKActivity med angivet id.
     */
    @GetMapping("/{id}")
    public TKActivity getTKActivities(@PathVariable Integer id) {
        return tkActivityService.getTKActivities(id);
    }

    /**
     * URI: /api/tk_activity
     * METOD: POST
     * Tar emot ett objekt i JSON format som sedan sparas i databasen.
     * @param tkActivity Det objekt som ska läggs till i databasen.
     */
    @PostMapping
    public void addTKActivity(@RequestBody TKActivity tkActivity) {
        tkActivityService.addTKActivity(tkActivity);
    }

    /**
     * URI: /api/tk_activity/{id}
     * METOD: DELETE
     * Tar bort en TKActivity från databasen med ett visst id.
     * @param id Id på det objekt som ska tas bort från databasen.
     */
    @DeleteMapping("/{id}")
    public void deleteTKactivity(@PathVariable Integer id) {
        tkActivityService.deleteTKActivity(id);
    }

    /**
     * URI: /api/tk_activity/{id}
     * METOD: PATCH
     * Uppdaterar en TKActivity i databasen med ett visst id.
     * @param id Id på det objekt som ska uppdateras i databasen.
     */
    @PatchMapping("/{id}")
    public void patchService(@PathVariable Integer id, @RequestBody TKActivity tkActivity) {
        tkActivityService.patchTKActivity(id, tkActivity);
    }
}
