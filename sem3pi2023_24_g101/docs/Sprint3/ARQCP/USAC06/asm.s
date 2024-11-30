.section .text
    .global extract_token

extract_token:
    movq $0, %r9
    movq $0, %r10
    movq $0, %rcx
    movl $0, (%rdx)


loop:
    movb (%rdi, %r9, 1), %al
    cmpb $0, %al
    je exit

    movb (%rsi, %r10, 1), %cl
    cmpb $0, %cl
    je exit

    cmpb %al, %cl
    je test_equal

    incq %r9
    jmp loop


test_equal:
    push %r9
    push %r10

    incq %r9
    incq %r10


loop2:
    movb (%rsi, %r10, 1), %cl
    cmpb $0, %cl
    je equal

    movb (%rdi, %r9, 1), %al
    cmpb $0, %al
    je exit

    cmpb %al, %cl
    jne not_equal

    incq %r9
    incq %r10
    jmp loop2


equal:
    movl $0, %eax

    movb (%rdi, %r9, 1), %al

    incq %r9

    cmpb $46, %al
    je equal

    cmpb $35, %al
    je end

    cmpb $0, %al
    je end

    movl (%rdx), %r8d
    imull $10, %r8d
    movl %r8d, (%rdx)

    sub $'0', %al
    addl %eax, (%rdx)

    jmp equal


not_equal:
    pop %r10
    pop %r9
    incq %r9
    jmp loop

exit:
    movl $1431655765, (%rdx)
    movq $0, %rax
    ret


end:
    pop %r10
    pop %r9
    movq $1, %rax
    ret


