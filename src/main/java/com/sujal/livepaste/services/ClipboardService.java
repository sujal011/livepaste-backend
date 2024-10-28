package com.sujal.livepaste.services;

import com.sujal.livepaste.models.ClipBoard;
import com.sujal.livepaste.repositories.ClipBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.security.SecureRandom;

@Service
public class ClipboardService {

    @Autowired
    private ClipBoardRepository clipBoardRepository;

    private static final String CHAR_POOL = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();

    public static String generateShortUrl(int length) {
        StringBuilder shortUrl = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            shortUrl.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));
        }
        return shortUrl.toString();
    }


    public ClipBoard createClipBoard(String paste) {
        String url;
        do {
            url = generateShortUrl(7);
        } while (clipBoardRepository.findByUrl(url).isPresent());
        String id = new Date().getTime() + "";
        ClipBoard clipBoard= new ClipBoard(id,paste,url);

        return clipBoardRepository.save(clipBoard);
    }

    public Optional<ClipBoard> getClipBoardByUrl(String url) {
        return clipBoardRepository.findByUrl(url);
    }

    public Optional<ClipBoard> getClipBoardById(String id){
        return clipBoardRepository.findById(id);
    }

    public Optional<ClipBoard> updateClipBoard(String id,String newPaste) {
        Optional<ClipBoard> clipBoard = getClipBoardById(id);
        clipBoard.ifPresent(clip->{
            clip.setPaste(newPaste);
            clipBoardRepository.save(clip);
        });
        return clipBoard;
    }

}
