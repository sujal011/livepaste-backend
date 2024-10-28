package com.sujal.livepaste.repositories;

import com.sujal.livepaste.models.ClipBoard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClipBoardRepository extends MongoRepository<ClipBoard,String> {
    Optional<ClipBoard> findByUrl(String url);
}
