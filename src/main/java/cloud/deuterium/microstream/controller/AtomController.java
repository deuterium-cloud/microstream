package cloud.deuterium.microstream.controller;

import cloud.deuterium.microstream.model.Atom;
import cloud.deuterium.microstream.repository.AtomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Milan Stojkovic 12-Oct-2021
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/atoms")
public class AtomController {

    private final AtomRepository atomRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello :)";
    }

    @GetMapping
    public List<Atom> getAllAtoms(){
        log.info("Getting all Atoms");
        return atomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Atom getAtomByName(@PathVariable int id){
        log.info("Getting Atom by id: {}", id);
        return atomRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Atom saveAtom(@PathVariable int id, @RequestBody Atom atom){
        log.info("Update Atom with id: {}", id);
        return atomRepository.updateById(id, atom);
    }

    @PostMapping
    public void saveAtom(@RequestBody Atom atom){
        log.info("Save new Atom: {}", atom);
        atomRepository.add(atom);
    }

    @DeleteMapping("/{id}")
    public void deleteAtom(@PathVariable int id){
        log.info("Delete Atom with id: {}", id);
        atomRepository.delete(id);
    }



}
