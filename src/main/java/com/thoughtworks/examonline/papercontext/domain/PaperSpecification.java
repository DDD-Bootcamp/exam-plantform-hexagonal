package com.thoughtworks.examonline.papercontext.domain;

/**
 * @author gitqh
 */
public interface PaperSpecification {
    boolean isSatisfiedBy(final Paper paper);
}
