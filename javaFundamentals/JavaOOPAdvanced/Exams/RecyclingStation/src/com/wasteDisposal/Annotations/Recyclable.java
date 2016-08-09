package com.wasteDisposal.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Disposable
@Retention(RetentionPolicy.RUNTIME)
public @interface Recyclable {
}
