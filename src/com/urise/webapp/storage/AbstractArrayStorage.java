package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void updateResume (int resumeExists, Resume r) {
        storage[resumeExists] = r;
    }

    @Override
    public void saveResume(Resume r) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow.", r.getUuid());
        } else {
            insert(r);
            size++;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Resume getResume(int resumeExists) {
        return storage[resumeExists];
    }

    public void deleteResume(int resumeExists) {
        size--;
        delete(resumeExists);
        storage[size] = null;
    }

    protected abstract void delete(int resumeExists);

    protected abstract int getIndex(String uuid);

    protected abstract void insert(Resume r);
    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}
