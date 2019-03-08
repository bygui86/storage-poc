package com.swissblock.storagepoc.mongodb.utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.util.StringUtils;


@Slf4j
@NoArgsConstructor
public final class ObjectIdUtils {

    public static String objectIdToString(final ObjectId id) {

        return id.toHexString();
    }

    public static ObjectId stringToObjectId(final String id) {

        if (!StringUtils.isEmpty(id)
                && ObjectId.isValid(id)) {
            return new ObjectId(id);
        }
        return null;
    }
}
