package cloud.deuterium.microstream.repository;

import cloud.deuterium.microstream.config.DB;
import cloud.deuterium.microstream.model.Atom;
import lombok.extern.slf4j.Slf4j;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Milan Stojkovic 12-Oct-2021
 */

@Slf4j
@Repository
public class AtomRepositoryImpl implements AtomRepository {

    private List<Atom> atoms;
    private EmbeddedStorageManager storage;

//    public AtomRepositoryImpl(@Value("${microstream.store.location}") final String location) {
//        super();
//        this.atoms = new ArrayList<>();
//        this.storage = EmbeddedStorage.start(
//                this.atoms,
//                Paths.get(location)
//        );
//    }

    @PostConstruct
    private void initialize(){
        this.atoms = DB.root.getAtoms();
        this.storage = DB.storageManager;
    }

    @Override
    public void storeAll() {
        this.storage.store(this.atoms);
    }

    @Override
    public void add(final Atom atom) {
        this.atoms.add(atom);
        this.storeAll();
    }

    @Override
    public List<Atom> findAll() {
        return this.atoms;
    }

    @Override
    public Atom updateById(int id, Atom atom) {
        Optional<Atom> first = this.atoms.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        if(first.isPresent()){
            Atom fromStorage = first.get();
            fromStorage.setName(atom.getName());
            fromStorage.setSymbol(atom.getSymbol());
            fromStorage.setDescription(atom.getDescription());
            fromStorage.setMass(atom.getMass());

            // Store only object which was changed
            this.storage.store(fromStorage);
            return fromStorage;
        }
        return new Atom();
    }

    @Override
    public void deleteAll() {
        this.atoms.clear();
        this.storeAll();
    }

    @Override
    public Atom findById(final int id) {
        return this.atoms.stream()
                .filter(atom -> atom.getId() == id)
                .findFirst()
                .orElse(new Atom());
    }

    @Override
    public void delete(int id) {
        this.atoms.removeIf(atom -> atom.getId() == id);
        this.storeAll();
    }
}
