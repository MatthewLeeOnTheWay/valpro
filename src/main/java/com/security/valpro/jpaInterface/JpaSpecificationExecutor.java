package com.security.valpro.jpaInterface;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface JpaSpecificationExecutor<T> {
    T findOne(Specification<T> spec);
    List<T> findAll(Specification<T> spec);
   /* Page<T> findAll(Specification<T> spec, SpringDataWebProperties.Pageable pageable);

    List<T> findAll(Specification<T> spec, SpringDataWebProperties.Sort sort);*/

    long count(Specification<T> spec);
}
