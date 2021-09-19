package id.diasna.refactor.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;

@Introspected(packages = "id.diasna.refactor.adapter.repository", includedAnnotations = javax.persistence.Entity.class)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}