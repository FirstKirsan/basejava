package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void Insert(Resume r) {
        int indexInsert = -1 - Arrays.binarySearch(storage, 0, size, r);
        System.arraycopy(storage, indexInsert, storage, indexInsert + 1, size - indexInsert);
        storage[indexInsert] = r;
    }

    protected void Delete(int resumeExists) {
        System.arraycopy(storage, resumeExists + 1, storage, resumeExists, size - resumeExists);
    }

}
