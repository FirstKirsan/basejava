package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
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
        else throw new NotExistStorageException(r.getUuid());
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) > -1) {
            throw new ExistStorageException(r.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow.", r.getUuid());
        } else {
            insert(r);
            size++;
        }
    }

    protected abstract void insert(Resume r);

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) return storage[resumeExists];
        else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract int getIndex(String uuid);

    public void delete(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) {
            size--;
            delete(resumeExists);
            storage[size] = null;
        } else throw new NotExistStorageException(uuid);
    }

    protected abstract void delete(int resumeExists);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}
