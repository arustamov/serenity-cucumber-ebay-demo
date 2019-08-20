package ebay.entities.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import ebay.entities.Entities;
import ebay.entity.property.PropertyEntity;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class FileEntities<E extends PropertyEntity> implements Entities<E, List<?>> {

    @Value("${entity.data.folder}")
    private String entityDataFolder;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private Faker faker;

    private Resource resource;
    private TypeReference<List<E>> typeReference;

    private List<E> entities;

    public FileEntities(String resourceClassPath, TypeReference<List<E>> typeReference) {
        this.resource = new ClassPathResource(String.format("data/%s", resourceClassPath));
        this.typeReference = typeReference;
    }

    @Override
    public Faker getFaker() {
        return faker;
    }

    @Override
    public E get(List<?> params, Boolean cached) {
        return getAll(params, false)
            .findFirst()
            .orElse(null);
    }

    @Override
    public Stream<E> getAll(List<?> params, Boolean cached) {
        if (entities == null)
            entities = readFile();
        return entities.stream();
    }

    protected List<E> readFile() {
        try {
            return entities = mapper.readValue(resource.getInputStream(), typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
