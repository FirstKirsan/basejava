package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int resumeExists = getIndex(r.getUuid());
        if (resumeExists > -1) storage[resumeExists] = r;
        else System.out.println("(UpDate) Error: Resume " + r + " does not exist.");
    }

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

    public Resume get(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) return storage[resumeExists];
        else {
            System.out.println("(Get) Error: Resume " + uuid + " does not exist.");
            return null;
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

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if ((storage[i] != null) && (storage[i].getUuid().equals(uuid))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
