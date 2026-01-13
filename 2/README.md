# Console CRUD (Gson + JSON files)

Консольное CRUD-приложение с сущностями:

- Writer (id, firstName, lastName, postIds, status)
- Post (id, title, content, labelIds, status)
- Label (id, name, status)
- Status: ACTIVE / DELETED (soft delete)

## Хранилище
Данные лежат в JSON файлах (текстовые файлы):
- `data/writers.json`
- `data/posts.json`
- `data/labels.json`

При удалении запись НЕ удаляется из файла — меняется `status` на `DELETED`.

## Запуск (Maven)
```bash
mvn -q -DskipTests package
java -jar target/console-crud-gson-1.0.0.jar
```

## Примечания
- Связи хранятся как списки id: Writer хранит `postIds`, Post хранит `labelIds`.
- В меню есть вывод только ACTIVE и вывод ALL (ACTIVE + DELETED).
