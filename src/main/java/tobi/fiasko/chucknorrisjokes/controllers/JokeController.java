package tobi.fiasko.chucknorrisjokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tobi.fiasko.chucknorrisjokes.model.Joke;
import tobi.fiasko.chucknorrisjokes.services.JokeServiceImpl;

@Controller
public class JokeController {

    JokeServiceImpl jokeService;

    public JokeController(JokeServiceImpl jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping(path = "/")
    public String getJokes(Model model) {
        Joke joke = new Joke();
        joke.setJoke(jokeService.createRandomizedJoke());
        model.addAttribute("joke", joke);

        return "index";
    }

}
