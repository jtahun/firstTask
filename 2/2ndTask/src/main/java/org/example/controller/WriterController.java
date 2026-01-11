package ru.igor.crud.controller;


public class WriterController {
    private final WriterRepository writerRepository;
    private final PostRepository postRepository;

    public WriterController(WriterRepository writerRepository, PostRepository postRepository) {
        this.writerRepository = writerRepository;
        this.postRepository = postRepository;
    }

    public Writer create(String firstName, String lastName, List<Long> postIds) {
        validateName(firstName, "firstName");
        validateName(lastName, "lastName");

        if (postIds != null) {
            // проверяем, что посты существуют и ACTIVE
            for (Long postId : postIds) {
                var post = postRepository.findById(postId).orElseThrow(
                        () -> new ValidationException("Post id=" + postId + " не найден"));
                if (post.getStatus() == Status.DELETED) {
                    throw new ValidationException("Post id=" + postId + " имеет статус DELETED");
                }
            }
        }

        Writer w = new Writer();
        w.setFirstName(firstName);
        w.setLastName(lastName);
        w.setPostIds(postIds);
        w.setStatus(Status.ACTIVE);
        return writerRepository.save(w);
    }

    public Writer getById(long id) {
        return writerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Writer id=" + id + " не найден"));
    }

    public List<Writer> listAll() {
        return writerRepository.findAll();
    }





 


}
