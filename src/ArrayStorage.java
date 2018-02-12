/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int resNum = 0;

    void clear() {
        for (int i = 0; i < resNum; i++) storage[i] = null;
        resNum = 0;
    }

    void save(Resume r) {
        storage[resNum] = r;
        resNum++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < resNum; i++) {
            if ((storage[i] != null) && (storage[i].uuid.equals(uuid))) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < resNum; i++) {
            if ((storage[i] != null) && (storage[i].uuid.equals(uuid))) {
                resNum--;
                storage[i] = storage[resNum];
                storage[resNum] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] st_getAll = new Resume[resNum];
        System.arraycopy(storage, 0, st_getAll, 0, resNum);
        return st_getAll;
    }

    int size() {
        return resNum;
    }
}
