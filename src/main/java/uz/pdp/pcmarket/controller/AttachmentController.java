package uz.pdp.pcmarket.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.pcmarket.dto.Response;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AttachmentController {
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public HttpEntity<?> uploadFilesToSystem(@RequestParam("files") MultipartFile[] multipartFiles,@RequestParam("images") MultipartFile[] multipartImages) {
        Response response = attachmentService.saveFiles(multipartFiles, multipartImages);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping
    public HttpEntity<?> getAttachments() {
        List<Attachment> attachmentList = attachmentService.findAll();
        return ResponseEntity.ok(attachmentList);
    }

    @PostMapping("/uploadSystem")
    public HttpEntity<?> uploadFileToFileSystem(MultipartHttpServletRequest request) {
        Response response = attachmentService.saveFile(request);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping("/download/{id}")
    public HttpEntity<?> getFileFromSystem(@PathVariable Integer id, HttpServletResponse response) {
        Response download = attachmentService.download(id, response);
        return ResponseEntity.status(download.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(download);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteFileFromSystem(@PathVariable Integer id) {
        Response delete = attachmentService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(delete);
    }
}
