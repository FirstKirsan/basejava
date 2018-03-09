package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("(Save) Error: resume " + r + " already exists.");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("(Save) Error: Storage overflow.");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void delete(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) {
            size--;
            storage[resumeExists] = storage[size];
            storage[size] = null;
        } else System.out.println("(Delete) Error: Resume " + uuid + " does not exist.");
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if ((storage[i] != null) && (storage[i].getUuid().equals(uuid))) {
                return i;
            }
        }
        return -1;
    }



}
