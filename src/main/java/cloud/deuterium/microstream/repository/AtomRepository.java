package cloud.deuterium.microstream.repository;

import cloud.deuterium.microstream.model.Atom;

import java.util.List;

/**
 * Created by Milan Stojkovic 12-Oct-2021
 */
public interface AtomRepository {
    void add(Atom atom);
    List<Atom> findAll();
    Atom findById(int id);
    Atom updateById(int id, Atom atom);
    void deleteAll();
    void storeAll();
    void delete(int id);
}
