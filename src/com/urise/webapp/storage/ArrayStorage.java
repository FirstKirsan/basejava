package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) storage[i] = null;
        size = 0;
    }

    public void update(Resume r) {
        int resumeExists = getIndex(r.getUuid());
        if (resumeExists > -1) storage[resumeExists] = r;
        else System.out.println("(UpDate) Error: Resume " + r + " does not exist.");
    }

    public void save(Resume r) {
        int resumeExists = getIndex(r.getUuid());
        if (resumeExists == -1) {
            storage[size] = r;
            size++;
        } else System.out.println("(Save) Error: resume " + r + " already exists.");
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
        Resume[] st_getAll = new Resume[size];
        System.arraycopy(storage, 0, st_getAll, 0, size);
        return st_getAll;
    }

    public int size() {
        return size;
    }
}
