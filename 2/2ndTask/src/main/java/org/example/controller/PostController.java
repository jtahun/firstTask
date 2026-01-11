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

}
