package ebay.entities;

import com.github.javafaker.Faker;
import ebay.entity.Entity;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Entities<E extends Entity, P extends List<?>> {

    Faker getFaker();

    E get(P params, Boolean cached);

    Stream<E> getAll(P params, Boolean cached);

    default E get(P params) {
        return get(params, false);
    }

    default Stream<E> getAll() {
        return getAll(null, false);
    }

    default Stream<E> getAll(P params) {
        return getAll(params, false);
    }

    default List<E> all(Stream<E> entities) {
        return entities
                .collect(Collectors.toList());
    }

    default E random(Stream<E> entities) {
        return random(entities, 1)
                .get(0);
    }

    default List<E> random(Stream<E> entities, Integer count) {
        List<E> entitiesList = entities
                .collect(Collectors.toList());
        if (entitiesList.size() < count)
            throw new RuntimeException(
                    String.format("Entities list size is %d, expected at least %d!",
                            entitiesList.size(),
                            count)
            );
        Collections.shuffle(entitiesList);
        return entitiesList.subList(0, count);
    }

    default E any(Stream<E> entities) {
        return entities
                .findAny()
                .orElseThrow(() -> new RuntimeException("Entities list is empty!"));
    }

    default E first(Stream<E> entities) {
        return entities
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Entities list is empty!"));
    }

    default E single(Stream<E> entities) {
        List<E> entitiesList = all(entities);
        if(entitiesList.size() == 0)
            throw new RuntimeException("Entities list is empty!");
        else if(entitiesList.size() > 1)
            throw new RuntimeException("Entities is not single!");
        return entitiesList.get(0);
    }

    default List<E> mapListToEntities(List<Map<String, Object>> mapList, Class<E> entityCLass) {
        return mapList
                .stream()
                .map(e -> {
                    try {
                        return entityCLass.getConstructor(Map.class).newInstance(e);
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());
    }
}
