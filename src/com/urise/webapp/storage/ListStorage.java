package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    protected ArrayList<Resume> storage = new ArrayList<>();

    public void clear() {
        storage.clear();
    }

    @Override
    public void updateResume(int resumeExists, Resume r) {
        storage.set(resumeExists, r);
    }

    @Override
    public void saveResume(Resume r) {
        storage.add(r);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public Resume getResume(int resumeExists) {
        return storage.get(resumeExists);
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size(); i++) {
            if ((storage.get(i) != null) && (storage.get(i).getUuid().equals(uuid))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void deleteResume(int resumeExists) {
        storage.remove(resumeExists);
    }

    @Override
    public Resume[] getAll() {
        Resume[] resTmp = new Resume[size()];
        storage.toArray(resTmp);
        return resTmp;
    }

}
