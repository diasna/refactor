/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.adapter;

import javax.inject.Singleton;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

import id.diasna.micronaut.usecase.port.IdGenerator;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
@Singleton
public class JugIdGenerator implements IdGenerator {

    @Override
    public String generate() {
        return generator().generate().toString();
    }

    private static NoArgGenerator generator() {
        return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }

}
