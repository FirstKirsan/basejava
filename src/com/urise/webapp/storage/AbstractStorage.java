package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public abstract class AbstractStorage implements Storage {

    protected Storage storage;

    public void update(Resume r) {
        int resumeExists = getIndex(r.getUuid());
        if (!(resumeExists > -1)) {
            throw new NotExistStorageException(r.getUuid());
        }
        else {
            updateResume(resumeExists, r);
        }
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) > -1) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r);
        }
    }
    
    public Resume get(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) return getResume(resumeExists);
        else {
            throw new NotExistStorageException(uuid);
        }
    }
    
    public void delete(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) {
            deleteResume(resumeExists);
        } else throw new NotExistStorageException(uuid);
    }

    protected abstract void deleteResume(int resumeExists);

    protected abstract Resume getResume(int resumeExists);

    protected abstract void saveResume(Resume r);

    protected abstract void updateResume(int resumeExists, Resume r);
    
    protected abstract int getIndex(String uuid);
}
