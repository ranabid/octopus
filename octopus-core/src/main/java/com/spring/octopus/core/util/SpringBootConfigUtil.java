package com.spring.octopus.core.util;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.function.Supplier;

public final class SpringBootConfigUtil {
    private SpringBootConfigUtil() { }

    public static <K, V> Map <K, V> buildPropertiesMap(final Environment environment, final String prefix,
                                                       final Class<T> propertyClass, final Supplier<T> defaultSupplier) {
        return Binder.get(environment).bind(prefix, propertyClass).orElse(defaultSupplier);

    }
}
