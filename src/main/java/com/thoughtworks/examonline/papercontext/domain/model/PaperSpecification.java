package com.thoughtworks.examonline.papercontext.domain.model;

/**
 * @author gitqh
 */
public interface PaperSpecification {
    boolean isSatisfiedBy(final Paper paper);
}
