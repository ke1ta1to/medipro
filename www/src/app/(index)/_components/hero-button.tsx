import { ComponentProps } from "react";

import { twMerge } from "tailwind-merge";

type HeroButtonProps = ComponentProps<"a">;

export function HeroButton({ children, ...props }: HeroButtonProps) {
  return (
    <a
      {...props}
      className={twMerge("rounded px-4 py-2 text-center", props.className)}
    >
      {children}
    </a>
  );
}
