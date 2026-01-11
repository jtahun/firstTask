package ru.igor.crud.controller;


public class WriterController {
    private final WriterRepository writerRepository;
    private final PostRepository postRepository;

    public WriterController(WriterRepository writerRepository, PostRepository postRepository) {
        this.writerRepository = writerRepository;
        this.postRepository = postRepository;
    }

}
