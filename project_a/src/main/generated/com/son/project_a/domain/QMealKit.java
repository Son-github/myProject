package com.son.project_a.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMealKit is a Querydsl query type for MealKit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMealKit extends EntityPathBase<MealKit> {

    private static final long serialVersionUID = -367341435L;

    public static final QMealKit mealKit = new QMealKit("mealKit");

    public final QAuditingFields _super = new QAuditingFields(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mCategory = createString("mCategory");

    public final StringPath mContent = createString("mContent");

    public final SetPath<MealKitComment, QMealKitComment> mealKitComments = this.<MealKitComment, QMealKitComment>createSet("mealKitComments", MealKitComment.class, QMealKitComment.class, PathInits.DIRECT2);

    public final StringPath mImage = createString("mImage");

    public final StringPath mName = createString("mName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath mPrice = createString("mPrice");

    public final StringPath mSite = createString("mSite");

    public final NumberPath<Integer> mStock = createNumber("mStock", Integer.class);

    public QMealKit(String variable) {
        super(MealKit.class, forVariable(variable));
    }

    public QMealKit(Path<? extends MealKit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMealKit(PathMetadata metadata) {
        super(MealKit.class, metadata);
    }

}
