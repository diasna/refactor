package id.diasna.refactor.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;

import javax.persistence.Entity;

@Introspected(packages = "id.diasna.refactor.adapter.repository", includedAnnotations = Entity.class)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}