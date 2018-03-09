package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) > -1) {
            System.out.println("(Save) Error: resume " + r + " already exists.");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("(Save) Error: Storage overflow.");
        } else {
            int indexInsert = -1 - Arrays.binarySearch(storage, 0, size, r);
            System.arraycopy(storage, indexInsert, storage, indexInsert + 1, size - indexInsert);
            storage[indexInsert] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int resumeExists = getIndex(uuid);
        if (resumeExists > -1) {
            size--;
            System.arraycopy(storage, resumeExists + 1, storage, resumeExists, size - resumeExists);
            storage[size] = null;
        } else System.out.println("(Delete) Error: Resume " + uuid + " does not exist.");
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
