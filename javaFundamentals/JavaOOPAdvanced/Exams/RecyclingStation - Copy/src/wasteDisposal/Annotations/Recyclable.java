package wasteDisposal.Annotations;

import wasteDisposal.enums.GarbageType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Disposable
@Retention(RetentionPolicy.RUNTIME)
public @interface Recyclable {
    GarbageType type = GarbageType.RECYCLABLE;
}
