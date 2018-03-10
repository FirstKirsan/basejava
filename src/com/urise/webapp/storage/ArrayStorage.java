package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if ((storage[i] != null) && (storage[i].getUuid().equals(uuid))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void Insert(Resume r) {
        storage[size] = r;
    }

    @Override
    protected void delete(int resumeExists) {
        storage[resumeExists] = storage[size];
    }
}
