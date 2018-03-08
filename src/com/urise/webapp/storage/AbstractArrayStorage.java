package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) return storage[resumeExists];
        else {
            System.out.println("(Get) Error: Resume " + uuid + " does not exist.");
            return null;
        }
    }

    protected abstract int getIndex(String uuid);

}
