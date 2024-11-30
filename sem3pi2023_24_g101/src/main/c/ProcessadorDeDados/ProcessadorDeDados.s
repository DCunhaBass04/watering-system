.section .text
	.global extract_token # void extract_token(char* input, char* token, int* output); USAC01
	.global enqueue_value # void enqueue_value(int* array, int length, int* read, int* write, int value); USAC02
	.global move_num_vec # int move_num_vec(int* array, int length, int* read, int* write, int num, int* vec); USAC03
	.global sort_array # void sort_array(int* vec, int num); USAC04
	.global mediana # int mediana(int* vec, int num); USAC05
	
	extract_token:
		movq $0, %r9
		movq $0, %r10
		movq $0, %rcx
		movl $0, (%rdx)


	extract_loop:
		movb (%rdi, %r9, 1), %al
		cmpb $0, %al
		je exit_extract

		movb (%rsi, %r10, 1), %cl
		cmpb $0, %cl
		je exit_extract

		cmpb %al, %cl
		je test_equal

		incq %r9
		jmp extract_loop


	test_equal:
		push %r9
		push %r10

		incq %r9
		incq %r10


	extract_loop2:
		movb (%rsi, %r10, 1), %cl
		cmpb $0, %cl
		je equal

		movb (%rdi, %r9, 1), %al
		cmpb $0, %al
		je exit_extract

		cmpb %al, %cl
		jne not_equal

		incq %r9
		incq %r10
		jmp extract_loop2


	equal:
		movl $0, %eax

		movb (%rdi, %r9, 1), %al

		incq %r9

		cmpb $46, %al
		je equal

		cmpb $35, %al
		je end_extract

		cmpb $0, %al
		je end_extract

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
		jmp extract_loop

	exit_extract:
		movl $1431655765, (%rdx)
		ret


	end_extract:
		pop %r10
		pop %r9
		ret








    enqueue_value:
        cmpl $0, %esi                       # Compare length with 0
        jle exit                            # End function for null or invalid size

        movq $0, %r9                        # Clear r9
        movq $0, %r10                       # Clear r10
        movq $0, %r11                       # Clear r11

        movl %esi,%r11d                     # Move size esi to r11d
        decl %r11d                          # Decrement size stored on r11d

        cmpl %r11d,(%rcx)                   # Compare value pointed by write pointer with size-1
        jg exit                             # End function if  write is bigger than size-1


    write:
        movl (%rcx), %r9d                   # Move value pointed by pointer to r9d
        movl %r8d,(%rdi,%r9,4)              # Write value r8d into array of index pointed by pointer
        addl $1,(%rcx)                      # Increment number pointed by write pointer
        cmpl (%rcx),%esi                    # Compare write +1  pointer with size
        je reset_write                      # Jump to reset_write function if write

    continue:
        movl (%rdx), %r10d                  # Move value pointed by read pointer to r10d
        cmpl (%rcx), %r10d                  # Compare value of write+1 with write  pointed by rcx and r10d pointers
        je increment_read                   # Jump to increment_read funcition if both are equal
        jmp exit                            # End function

    reset_write:
        movl $0 ,(%rcx)                     # Move 0 to value pointed by rcx write pointer
        jmp continue                        # Jump to continue

    increment_read:
        addl $1,(%rdx)                      # Increment value poined by read pointer
        jmp exit                            # End function




move_num_vec:
	pushq %rbx
	pushq %r10
	movl $0, %ebx
	movl (%rcx), %eax
	subl (%rdx), %eax
	addl %esi, %eax
	pushq %rdx
	cltd
	idivl %esi
	cmpl %edx, %r8d
	jg end_invalid
	popq %rdx

loop_buffer:
	cmpl %ebx, %r8d
	je end_valid
	movl (%rdx), %eax
	movl (%rdi, %rax, 4), %r10d
	movl %r10d, (%r9, %rbx, 4)
	pushq %rdx
	incl %eax
	cltd
	idivl %esi
	movl %edx, %r10d
	popq %rdx
	movl %r10d, (%rdx)
	incl %ebx
	jmp loop_buffer

end_invalid:
	movl $0, %eax
	popq %rdx
	popq %r10
	popq %rbx
	ret

end_valid:
	movl $1, %eax
	popq %r10
	popq %rbx
	ret






    sort_array:
        cmpl $0, %esi                    # Compare size (num) with 0
        jle exit                          # End function for invalid or null siz

        movq $0, %rcx                    # Initialize first counter rcx = 0 for outer loop (i)
        movq $0, %rdx                    # Initialize second counter rdx = 0 for inner loop j=i+1,
        movq $0, %rax                    # Initialize %rax = 0
        movl %esi,%eax                   # Move array size %esi to %eax
        decl %eax                        # Decrement %eax = n-1 for first loop

    main_loop:
        cmpl %ecx,%eax                   # Compare actual size with final size(n-1)
        je exit                          # End function when counter reaches final size (n-1)
        movl %ecx, %edx                  # Move first counter %ecx to second %edx
        incl %edx                        # Increment second counter j = i+1

        call inner_loop                  # Call inner_loop to loop on every main_loop iteration returns on next line

        incl %ecx                        # Increment first counter i
        jmp main_loop                    # Jump to beginning of the main_loop


    inner_loop:         	             # Inner loop function
        cmpl %edx, %esi    		         # Compare second counter j to array size
        je exit  				         # Jump to outer loop when j reaches final size i
        movl (%rdi, %rcx, 4), %r10d      # Load vec[i] into %r10d
        movl (%rdi, %rdx, 4), %r8d       # Load vec[j] into %r8d

        cmpl %r10d, %r8d                 # Compare vec[j] to vec[i]
        jl swap_elements                 # If r8d is smaller than r10,vec[j] < vec[i],jump to swap_elements

    continue_sorting:                            # Continue here after the inner loop
        incl %edx                        # Increment j
        jmp inner_loop                   # Jump to the beginning of the inner loop


    swap_elements:       			     # Swap vec[i] and vec[j] if needed
        movl %r10d,(%rdi, %rdx, 4)       # Move vec[j] to vec[i]
        movl %r8d,(%rdi, %rcx, 4)        # Move vec[i] to vec[j]
        jmp continue_sorting    			     # Continue to the inner loop









	mediana:
		movq $0, %rax				#clean %rax
		cmpl $0, %esi
		je exit
		call sort_array
		movq $0, %rdx				#clean %rdx
		movq $0, %rax				#clean %rax
		movq $2, %rcx				#clean %rcx, passing the value 2 to it
		movl %esi, %eax				#pass "num" to %eax
		divl %ecx					#divide %eax by 2, passing the final value to %eax and the remainder to %edx
		movl (%rdi, %rax, 4), %eax	#pass the middle value to %eax (if num is 7, it will pass the element with the index 3, the 4th element) 
									#(if num is an even number, the median will be the point in the position n/2, as requested (if size is 8, median is element with index 4, the 5th element))
		jmp exit
				
    exit:                                     # End of the function
		ret
