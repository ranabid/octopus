package com.spring.octopus.core.util;

import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

/**
 * Binder API - The Binder class (in
 * org.springframework.boot.context.properties.bind) lets you take one or more
 * ConfigurationPropertySource and bind something from them. More precisely, a
 * Binder takes a Bindable and returns a BindResult. link:
 * https://spring.io/blog/2018/03/28/property-binding-in-spring-boot-2-0
 * 
 * SpringBootConfigUtil - Utilities for dealing with dynamically management
 * properties classes when @EnableConfigurationProperties is not available.
 */
public final class SpringBootConfigUtil {
	
	private SpringBootConfigUtil() { }

	/**
	 * 
	 * @param <T>             The type of the object to create from the
	 *                        configuration
	 * @param environment     The current environment
	 * @param prefix          The prefix that identifies the subset of the
	 *                        properties to use.
	 * @param propertyClass   The class to deserialize into.
	 * @param defaultSupplier A Supplier to use if the properties is not found
	 * @return The bean containing the defined configuration from the properties.
	 */
	public static <T> T buildPropertiesObject(final Environment environment, final String prefix,
			final Class<T> propertyClass, final Supplier<T> defaultSupplier) {
		return Binder.get(environment).bind(prefix, propertyClass).orElseGet(defaultSupplier);
	}

	/**
	 * 
	 * @param <K>         The key type for the resulting map.
	 * @param <V>         The value type for the resulting map.
	 * @param environment The current environment
	 * @param prefix      The prefix that identifies the subset of the properties to
	 *                    use.
	 * @param valueClass  The class to deserialize into for the Map value.
	 * @return The bean containing the defined configuration from the properties.
	 */
	public static <K, V> Map<String, V> buildPropertiesMap(final Environment environment, final String prefix,
			final Class<V> valueClass) {
		return buildPropertiesMap(environment, prefix, String.class, valueClass);
	}

	/**
	 * 
	 * @param <K>         The key type for the resulting map.
	 * @param <V>         The value type for the resulting map.
	 * @param environment The current environment
	 * @param prefix      The prefix that identifies the subset of the properties to
	 *                    use.
	 * @param keyClass    The class to deserialize into for the Map key.
	 * @param valueClass  The class to deserialize into for the Map value.
	 * @return The bean containing the defined configuration from the properties.
	 */
	public static <K, V> Map<K, V> buildPropertiesMap(final Environment environment, final String prefix,
			final Class<K> keyClass, final Class<V> valueClass) {
		return Binder.get(environment).bind(prefix, Bindable.mapOf(keyClass, valueClass)).orElseGet(HashMap::new);
	}

}
