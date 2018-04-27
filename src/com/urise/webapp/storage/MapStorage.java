package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractStorage {
    @Override
    protected void deleteResume(int resumeExists) {

    }

    @Override
    protected Resume getResume(int resumeExists) {
        return null;
    }

    @Override
    protected void saveResume(Resume r) {

    }

    @Override
    protected void updateResume(int resumeExists, Resume r) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
