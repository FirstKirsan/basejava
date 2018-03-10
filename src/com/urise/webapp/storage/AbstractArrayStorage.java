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
        if (getIndex(r.getUuid()) > -1) {
            System.out.println("(Save) Error: resume " + r + " already exists.");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("(Save) Error: Storage overflow.");
        } else {
            Insert(r);
            size++;
        }
    }

    protected abstract void Insert(Resume r);

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

    public void delete(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) {
            size--;
            Delete(resumeExists);
            storage[size] = null;
        } else System.out.println("(Delete) Error: Resume " + uuid + " does not exist.");
    }

    protected abstract void Delete(int resumeExists);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}
