package org.victorynox.memorator.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victorynox.memorator.domain.*;
import org.victorynox.memorator.domain.exception.InvalidPhrasePositionException;
import org.victorynox.memorator.domain.repositories.ImageRepository;
import org.victorynox.memorator.domain.repositories.LabelRepository;
import org.victorynox.memorator.domain.repositories.MemRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

/**
 * @author victorynox
 * @version 0.1
 */
@Service
public class MemGeneratorImpl implements MemGenerator {

    /**
     * Mem repository
     */
    private final MemRepository memRepository;

    /**
     * image repository
     */
    private final ImageRepository imageRepository;

    /**
     * label repository
     */
    private final LabelRepository labelRepository;

    @Autowired
    public MemGeneratorImpl(MemRepository memRepository, ImageRepository imageRepository, LabelRepository labelRepository) {
        this.memRepository = memRepository;
        this.imageRepository = imageRepository;
        this.labelRepository = labelRepository;
    }

    @Transactional(value = Transactional.TxType.SUPPORTS, rollbackOn = InvalidPhrasePositionException.class)
    public void generateSimpleMem(UUID imageId, String text) throws InvalidPhrasePositionException
    {
        Optional<Image> isImage = imageRepository.findById(imageId);
        if(isImage.isPresent()) {
            Image image = isImage.get();
            Mem mem = new Mem(image);
            Label label = new Label(mem, new Point(0, 0), new Phrase(text));
            mem.addLabel(label);
            labelRepository.save(label);
            memRepository.save(mem);
        }
    }
}
