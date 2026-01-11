package ru.igor.crud.controller;

public class PostController {
    private final PostRepository postRepository;
    private final LabelRepository labelRepository;

    public PostController(PostRepository postRepository, LabelRepository labelRepository) {
        this.postRepository = postRepository;
        this.labelRepository = labelRepository;
    }

    public Post create(String title, String content, List<Long> labelIds) {
        validateNotBlank(title, "title");

        if (labelIds != null) {
            for (Long labelId : labelIds) {
                var label = labelRepository.findById(labelId).orElseThrow(
                        () -> new ValidationException("Label id=" + labelId + " не найден"));
                if (label.getStatus() == Status.DELETED) {
                    throw new ValidationException("Label id=" + labelId + " имеет статус DELETED");
                }
            }
        }

        Post p = new Post();
        p.setTitle(title);
        p.setContent(content == null ? "" : content);
        p.setLabelIds(labelIds);
        p.setStatus(Status.ACTIVE);
        return postRepository.save(p);
    }

    public Post getById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Post id=" + id + " не найден"));
    }

    public List<Post> listAll() {
        return postRepository.findAll();
    }

    public List<Post> listActive() {
        return postRepository.findAll().stream()
                .filter(p -> p.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());
    }

    public Post update(long id, String title, String content, List<Long> labelIds) {
        Post existing = getById(id);
        if (existing.getStatus() == Status.DELETED) {
            throw new DeletedEntityException("Post id=" + id + " удалён (DELETED), редактирование запрещено");
        }
        return existing;
    }
}
