package com.minticlau.reto3.Controller;

import com.minticlau.reto3.Model.Score;
import com.minticlau.reto3.Service.ScoreService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ScoreController {
 
      @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")

    public List<Score> getScoreAll() {
        return scoreService.getScoreAll();
    }

    @GetMapping({"/id"})

    public Optional<Score> getScoreId(@PathVariable("id") Integer identificador) {
        return scoreService.getScoreId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)

    public Score saveScore(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return scoreService.updateScore(score);
    }

}
