package id.diasna.refactor.adapter;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import id.diasna.refactor.port.IdGenerator;

public class JugIdGenerator implements IdGenerator {

    @Override
    public String generate() {
        return generator().generate().toString();
    }

    private static NoArgGenerator generator() {
        return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }

}
