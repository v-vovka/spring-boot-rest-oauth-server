package com.tas.app.repository.spec;

import com.tas.app.model.Customer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir Vashchuk on 30.05.2018
 */
public class CustomerSpecificationsBuilder {

    private final List<SearchCriteria> params;

    public CustomerSpecificationsBuilder() {
        this.params = new ArrayList<>();
    }

    public CustomerSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Customer> build() {
        if (params.isEmpty()) {
            return null;
        }

        List<Specification<Customer>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new CustomerSpecification(param));
        }

        Specification<Customer> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CustomerSpecificationsBuilder that = (CustomerSpecificationsBuilder) o;

        return new EqualsBuilder()
                .append(params, that.params)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(params)
                .toHashCode();
    }
}
