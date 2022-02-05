package cloud.deuterium.microstream.config;

import cloud.deuterium.microstream.model.Atom;
import one.microstream.reference.Lazy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Milan Stojkovic 12-Oct-2021
 */
public class DataRoot {
    private final List<Atom> atoms = new ArrayList<>();
    private final Set<Atom> atomSet = new HashSet<>();
    private final Lazy<Set<Atom>> lazySet = Lazy.Reference(new HashSet<>());

    public List<Atom> getAtoms() {
        return atoms;
    }

    public Set<Atom> getAtomSet() {
        return atomSet;
    }

    public Lazy<Set<Atom>> getLazySet() {
        return lazySet;
    }
}
